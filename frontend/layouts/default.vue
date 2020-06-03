<template>
  <v-app dark>
    <v-app-bar fixed app>
      <Navigation />
      <v-spacer />
       <v-switch v-model="$vuetify.theme.dark" hide-details inset> <v-icon>home</v-icon></v-switch>
       <v-divider class="mx-4" vertical></v-divider>
       <nuxt-link v-if="$i18n.locale !== 'en'" :to="switchLocalePath('en')">En</nuxt-link>
       <nuxt-link v-if="$i18n.locale !== 'es'" :to="switchLocalePath('es')">Es</nuxt-link>
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
import Navigation from '~/components/Navigation.vue'
export default {
  components: {
    Navigation,
  }
}
</script>

<style>
.theme--dark.v-app-bar.v-toolbar.v-sheet {
    background-color: white;
}

.v-content__wrap {
      top: -82px;
}

#container-global {
  padding-bottom: 150px;;
}
</style>