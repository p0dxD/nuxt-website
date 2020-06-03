<template>
  <!-- <div class="home_image"></div> -->
  <v-layout column justify-center align-center>
    <v-flex xs12 sm8 md6>
      <v-row align="center" justify="center">
        <v-col cols="12" sm="12">
          <div class="home_image"></div>
        </v-col>
      </v-row>

      <v-row align="center" justify="center">
        <v-col cols="5" sm="4">
          <div id="personal-card">
            <span class="dot"></span>
            <h4 class="name-title">Software Engineer</h4>
          </div>
        </v-col>
      </v-row>

      <v-row align="center" justify="center">
        <v-col cols="12" sm="12">
          <ContentIndex class="content-index"/>
        </v-col>
      </v-row>
    </v-flex>
  </v-layout>
</template>

<script>
// import Logo from '~/components/Logo.vue'
import ContentIndex from "~/components/ContentIndex.vue";

export default {
  components: {
    ContentIndex
  }
};
</script>

<style>
.container {
  top: 60px;
  position: relative;
  height: 110%;
  /* border-style: dashed; */
}
.home_image {
  /* z-index: -10; */
  /* position: absolute; */
  width: 100%;
  height: 300px;
  /* top: 6px; */
  background-image: url("../assets/nyc.jpg");
  background-repeat: no-repeat;
  background-position: center;
  background-size: cover;
  left: 0;
}

.dot {
  height: 200px;
  width: 200px;
  background-image: url("../assets/me_2.png");
  border-radius: 50%;
  display: inline-block;
  background-size: 200px 200px;
  box-shadow: 1px 1px 10px grey;
}
.name-title {
  letter-spacing: 3px;
  text-transform: capitalize;
  padding: 10px;
  font-size: 17px;
}
#personal-card {
  z-index: 100;
    position: relative;
    top: -100px;
  /* border-style: dashed; */
}

.content-index {
  top: -100px;
  position: relative;
  /* border-style: dashed; */
}
@media screen and (max-width: 900px) and (min-width: 600px) {
  .dot {
    height: 180px;
    width: 180px;
    background-size: 180px 180px;
  }
  .name-title {
    font-size: 16px;
  }
}
@media screen and (max-width: 600px) and (min-width: 550px) {
  .dot {
    height: 160px;
    width: 160px;
    background-size: 160px 160px;
  }
  .name-title {
    font-size: 15px;
  }
}
@media screen and (max-width: 550px) and (min-width: 540px) {
  .dot {
    height: 140px;
    width: 140px;
    background-size: 140px 140px;
  }
  .name-title {
    font-size: 14px;
  }
}
@media screen and (max-width: 540px) and (min-width: 470px) {
  .dot {
    height: 120px;
    width: 120px;
    background-size: 120px 120px;
  }
  .name-title {
    font-size: 13px;
  }
}
@media screen and (max-width: 469px) {
  .dot {
    height: 110px;
    width: 110px;
    background-size: 110px 110px;
  }
  .name-title {
    font-size: 12px;
  }
}
@media screen and (max-width: 340px) {
  .name-title {
    font-size: 10px;
  }
  /* #perfornal-card{
        top: -150px;
  } */
}
</style>