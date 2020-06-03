<template>
  <v-layout>
    <v-flex class="text-center">
      <div id="container-project">
        <div>
          <h1 class="titles">Projects</h1>
          <div xs4 md4>
            <div v-for="(test,da) in info" :key="da">
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
            </div>
          </div>
        </div>
      </div>
    </v-flex>
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
    const ip = await $axios.$get("http://localhost:49160/api/hello");
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