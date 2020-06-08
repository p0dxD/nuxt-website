<template>
  <div>
    <nuxt-link class="menu-bar" :to="localePath('/')" exact>{{ $t('home_title_text') }}</nuxt-link>
    <nuxt-link class="menu-bar" :to="localePath('/projects')">{{ $t('projects_title_text') }}</nuxt-link>
    <nuxt-link class="menu-bar" :to="localePath('/contact')">{{ $t('contact_title_text') }}</nuxt-link>
    <a class="menu-bar" href="https://joserod.space:81">Blog</a>
  </div>
</template>

<style scoped>
.menu-bar {
  margin-right: 20px;
  font-size: 14px;
  color: #999;
  text-decoration: none;
  text-transform: uppercase;
  padding-top: 2px;
  padding-bottom: 2px;
  border-top: 1px solid transparent;
  border-bottom: 1px solid transparent;
  transition: color 0.25s;
  font-weight: 400;
  line-height: normal;
  cursor: pointer;
}
.menu-bar:hover {
  color: #333;
}
.menu-bar.nuxt-link-active {
  color: #333;
  border-top: 1px solid #333;
  border-bottom: 1px solid #333;
  font-weight: 600;
}
</style>