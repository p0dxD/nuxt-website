import VueCookie from 'vue-cookie'

export default async function ({app, store}) {
    // on change locale
    app.i18n.beforeLanguageSwitch = (oldLocale, newLocale) => {
      console.log("testing " + oldLocale + " " + newLocale)
      localStorage.locale = newLocale;
      if (process.browser) {
        if (VueCookie.get('i18n_redirected') !== newLocale) {
          VueCookie.set('i18n_redirected', newLocale)
        }
      }
    }
  }