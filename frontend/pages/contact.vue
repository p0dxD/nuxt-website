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
        <v-col cols="12" md="12">
          <vue-recaptcha
            sitekey="6LeJBAAVAAAAABN19qBxLYn8IiRFsOVGxTzEZxtI"
            :loadRecaptchaScript="true">
            <button color="pink" text v-on:click="greet">Submit</button>
          </vue-recaptcha>
          <v-snackbar v-model="snackbar">
            {{ snackBarText }}
            <v-btn color="pink" text @click="snackbar = false">Close</v-btn>
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
  async asyncData({ app }) {
    return {
      valid: false,
      firstname: "",
      lastname: "",
      email: "",
      message: "",
      snackBarText: "Invalid input, please try again.",
      snackbar: false,
    };
  },
  // define methods under the `methods` object
  methods: {
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
        this.snackbar = true
        return;
      }
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

.grecaptcha-badge{
  bottom: 38px !important;
}

</style>