<template>
  <div class="test">
    <nuxt-link to="/" exact>Home</nuxt-link>
    <nuxt-link to="/projects">Projects</nuxt-link>
    <nuxt-link to="/contact">Contact</nuxt-link>
  </div>
</template>

<style scoped>
.test {
  display: flex;
  margin-bottom: 20px;
}
a {
  margin-right: 20px;
  font-size: 14px;
  color: #999;
  text-decoration: none;
  text-transform: uppercase;
  padding-top: 2px;
  padding-bottom: 2px;
  border-top: 1px solid transparent;
  border-bottom: 1px solid transparent;
  transition: color .25s;
  font-weight: 400;
  line-height: normal;
  cursor: pointer;
}
a:hover {
  color: #333;
}
a.nuxt-link-active {
  color: #333;
  border-top: 1px solid #333;
  border-bottom: 1px solid #333;
  font-weight: 600;
}
</style>