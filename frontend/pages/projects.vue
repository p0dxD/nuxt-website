<template>
  <v-layout>
    <v-row>
      <v-col cols="12" md="12">
        <v-flex class="text-center"><h1 class="titles">Projects</h1></v-flex>
      </v-col>
          <v-flex class="text-center" v-for="(test,da) in info" :key="da">
            <v-col cols="12" md="12" xs="12">
            <v-card class="d-flex align-content-start flex-wrap mx-auto">
              <v-card-text>
                <v-btn
                  v-bind:href="test.htmlUrl"
                  outlined
                  class="align-content-center text--primary"
                >{{ test.name }}</v-btn>
                <p>Technologies used:</p>
                <div class="text--primary">{{test.languages}}</div>
                <br />
                <p>Last updated: {{test.dateLastUpdated}}</p>
                <p>Date created: {{test.dateCreated}}</p>
              </v-card-text>
            </v-card>
            </v-col>
          </v-flex>
    </v-row>
  </v-layout>
</template>

<script>
export default {
  name: "Projects" //  this is the name of the component
};
</script>
<style>
</style>

<script>
export default {
  name: "Projects",
  async asyncData({ $axios }) {
    $axios.setHeader("Authorization", "Basic dGVzdDpwYXNzd29yZA==");
    const ip = await $axios.$get("https://joserod.space:49160/api/hello");
    return {
      info: ip
    };
  }
};
</script>

<style>
.md-card.md-with-hover {
  height: 98%;
  right: -3px;
}
#container-project {
  position: relative;
}

a {
  color: blueviolet;
}

.titles {
  color: #7c795d;
  font-family: "Trocchi", serif;
  font-size: 45px;
  font-weight: normal;
  line-height: 48px;
  margin: 0;
  padding: 25px;
}
.subtitles {
  color: #7c795d;
  font-family: "Source Sans Pro", sans-serif;
  font-size: 15px;
  font-weight: 400;
  line-height: 32px;
}

.md-card .md-subhead {
  padding-bottom: 15px;
}

.vertical-center {
  margin: 0;
  position: absolute;
  top: 50%;
  -ms-transform: translateY(-50%);
  transform: translateY(-50%);
}
</style>