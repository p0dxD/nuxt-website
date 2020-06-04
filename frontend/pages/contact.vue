<template>
  <v-form v-model="valid">
    <v-container>
      <v-row>
        <v-col cols="12" md="4">
          <v-text-field
            v-model="firstname"
            :rules="nameRules"
            :counter="30"
            label="First name"
            required
          ></v-text-field>
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field
            v-model="lastname"
            :rules="nameRules"
            :counter="30"
            label="Last name"
            required
          ></v-text-field>
        </v-col>

        <v-col cols="12" md="8">
          <v-text-field v-model="email" :rules="emailRules" label="E-mail" required></v-text-field>
        </v-col>
      </v-row>

      <v-row>
        <v-col cols="12" md="8">
          <v-textarea
            v-model="message"
            label="Message"
            counter
            maxlength="320"
            full-width
            single-line
          ></v-textarea>
        </v-col>
      </v-row>
      <v-row>
        <v-col cols="12" md="12" class="btn-submit">
          <vue-recaptcha
            sitekey="6LeJBAAVAAAAABN19qBxLYn8IiRFsOVGxTzEZxtI"
            :loadRecaptchaScript="true"
          >
            <v-btn color="primary" v-on:click="greet">Submit</v-btn>
          </vue-recaptcha>
          <v-snackbar v-model="snackbar">
            {{ snackBarText }}
            <v-btn color="pink" :timeout="timeout" text @click="snackbar = false">Close</v-btn>
          </v-snackbar>
        </v-col>
      </v-row>
    </v-container>
  </v-form>
</template>

<script>
import VueRecaptcha from "vue-recaptcha";
export default {
  name: "Contact",
  components: { VueRecaptcha },
  data() {
    return {
      name: "test",
      nameRules: [
        v => !!v || "Name is required",
        v => v.length <= 30 || "Name must be less than 10 characters"
      ],
      emailRules: [
        v => !!v || "E-mail is required",
        v => /.+@.+/.test(v) || "E-mail must be valid"
      ]
    };
  },
  async asyncData({ $axios }) {
    //get the status of server for email
    $axios.setHeader("Authorization", "Basic dGVzdDpwYXNzd29yZA==");
    const status = await $axios.$get("https://joserod.space:49160/api/status").catch(function(error) {
      console.log("Error code: " +error.response.status)
    });//should return okay if good

    return {
      valid: false,
      firstname: "",
      lastname: "",
      email: "",
      message: "",
      snackBarText: "Invalid input, please try again.",
      snackbar: false,
      status: status,
      timeout: 5000
    };
  },
  mounted:function(){
        this.printServiceStatus() //method1 will execute at pageload
  },
  // define methods under the `methods` object
  methods: {
    printServiceStatus: function(event) {
      console.log(this.status)
      if(this.status == "okay") {
        this.snackBarText = "Email service is up."
        this.snackbar = true
      } else {
        this.snackBarText = "Email service is down. Contact me at jose0797@gmail.com"
        this.snackbar = true
      }
    },

    greet: function(event) {
      // `this` inside methods point to the Vue instance
      if (
        this.firstname == null ||
        this.firstname.length <= 0 ||
        this.lastname == null ||
        this.lastname.length <= 0 ||
        this.email == null ||
        this.email.length <= 0 ||
        this.message.length <= 0 ||
        this.message == null
      ) {
        this.snackbar = true;
        return;
      }

      // const ip = await this.$axios.$get('http://icanhazip.com')

      let result =  this.$axios.post('https://joserod.space:49160/api/email', {headers: {"Authorization": "Basic dGVzdDpwYXNzd29yZA==", "Content-Type": "application/json"},
                    data: {
                      full_name: this.firstname + this.lastname,
                      email: this.email,
                      message: this.message
                    }})

      console.log("Hello " + this.firstname + this.lastname + "!");
      console.log("Your email is: " + this.email);
      console.log("Your message is: " + this.message);
    }
  }
};
</script>

<style>
.theme--dark.v-app-bar.v-toolbar.v-sheet {
  background-color: white;
}

/* .v-content__wrap {
  height: 100%;
} */

.grecaptcha-badge {
  bottom: 38px !important;
}

.btn-submit {
  padding-bottom: 30px;
}
</style>