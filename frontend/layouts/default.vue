<template>
  <v-app dark>
    <v-app-bar fixed app>
      <Navigation />
      <v-spacer />
      <v-switch v-model="$vuetify.theme.dark" hide-details inset>
        <v-icon>home</v-icon>
      </v-switch>
      <v-divider class="mx-4" vertical></v-divider>
      <nuxt-link
        v-for="locale in availableLocales"
        :key="locale.code"
        :to="switchLocalePath(locale.code)"
      >{{ locale.code.toUpperCase() }}</nuxt-link>
    </v-app-bar>
    <v-content id="container-global">
      <v-container>
        <nuxt />
      </v-container>
    </v-content>
    <v-footer app>
      <span>&copy; {{ new Date().getFullYear() }}</span>
    </v-footer>
  </v-app>
</template>

<script>
import Navigation from "~/components/Navigation.vue";
export default {
  components: {
    Navigation
  },
  asyncData({ app }) {
    const locale = app.i18n.locale;
    console.log("localte" + locale);
    return {
      locale
    };
  },
  data() {
    return {
      language: "en"
    };
  },
  // mounted() {
  //   console.log("Mounted: " + localStorage.locale)
  //   if (localStorage.locale) {
  //     this.$i18n.localePath(localStorage.locale)
  //   }
  // },
  computed: {
    availableLocales() {
      return this.$i18n.locales.filter(i => i.code !== this.$i18n.locale);
    }
  }
};
</script>

<style>
.theme--dark.v-app-bar.v-toolbar.v-sheet {
  background-color: white;
}

.v-content__wrap {
  top: -82px;
}

#container-global {
  padding-bottom: 150px;
}
</style>