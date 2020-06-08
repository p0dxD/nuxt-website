import colors from 'vuetify/es5/util/colors'
import fs from 'fs'
import path from 'path'

export default {
  mode: 'universal',
  server: {
    https: {
      key: fs.readFileSync(path.resolve(__dirname, 'private.pem')),
      cert: fs.readFileSync(path.resolve(__dirname, 'public.pem'))
    }
  },

  /*
  ** Headers of the page
  */
  head: {
    titleTemplate: '%s - ' + process.env.npm_package_name,
    title: process.env.npm_package_name || '',
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: process.env.npm_package_description || '' }
    ],
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }
    ]
  },
  /*
  ** Customize the progress-bar color
  */
  loading: { color: '#fff' },
  /*
  ** Global CSS
  */
  css: [
  ],
  /*
  ** Plugins to load before mounting the App
  */
  plugins: [
    {
      src: '~/plugins/vue-apexcharts',
      ssr: false
    },
    '~/plugins/i18n.js'
  ],
  /*
  ** Nuxt.js dev-modules
  */
  buildModules: [
    '@nuxtjs/vuetify',
  ],
  /*
  ** Nuxt.js modules
  */
  modules: [
    [
      'nuxt-i18n',
      {
        detectBrowserLanguage: {
          useCookie: true,
          cookieKey: 'lang',
          alwaysRedirect: true,
          fallbackLocale: 'en'
        },
        vuex: {
          moduleName: 'i18n',
          mutations: {
            setLocale: 'I18N_SET_LOCALE',
            setMessages: false
          },
          preserveState: false
        },
        locales: [
          {
            code: 'en',
            iso: 'en-US',
            name: 'English',
            file: 'en/index.js'
          },
          {
            code: 'es',
            iso: 'es-ES',
            name: 'Español',
            file: 'es/index.js'
          },
          {
            code: '中文',
            iso: 'zh-CN',
            name: 'Simplified-Chinese',
            file: 'ch/index.js'
          }
        ],
        lazy: true,
        seo: false,
        langDir: '/locales/',
        defaultLocale: 'en',
        parsePages: false,
        onLanguageSwitched: (previous, current) => {
          if (process.client) {
            const DATE = new Date();
            DATE.setTime(DATE.getTime() + 365 * 24 * 3600 * 1000);
            document.cookie = 'lang=' + current + '; path=/; expires=' + DATE.toUTCString();
          }
        }
      }
    ],
    '@nuxtjs/axios',
  ],
  axios: {
    // proxyHeaders: false
  },
  /*
  ** vuetify module configuration
  ** https://github.com/nuxt-community/vuetify-module
  */
  vuetify: {
    customVariables: ['~/assets/variables.scss'],
    theme: {
      dark: false,
      themes: {
        dark: {
          primary: colors.blue.darken2,
          accent: colors.grey.darken3,
          secondary: colors.amber.darken3,
          info: colors.teal.lighten1,
          warning: colors.amber.base,
          error: colors.deepOrange.accent4,
          success: colors.green.accent3
        }
      }
    }
  },
  /*
  ** Build configuration
  */
  build: {
    vendor: ['aframe'],
    /*
    ** You can extend webpack config here
    */
    extend (config, ctx) {
    }
  }
}
