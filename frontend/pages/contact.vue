<template>
  <div>
    <h1>Contact Me</h1>
  <p>
    <ul>
      <ul>Email: {{email}}</ul>
      <ul>Website: {{web}}</ul>
    </ul>
  </p>
  </div>
</template>

<script>
export default {
  name: 'Contact',
    async asyncData({ app }) {
    return {
      email: 'jose0797@gmail.com',
      web: 'joserod.space'
    };
  }
}
</script>