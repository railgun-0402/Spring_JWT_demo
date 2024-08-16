<template>
  <div id="app">
    <ul>
      <li><router-link to="/">Home</router-link></li>
      <li><router-link to="/login">Login</router-link></li>
      <li><router-link to="/gacha">Gacha</router-link></li>
      <li><router-link to="/character">Character</router-link></li>
    </ul>
    <router-view/>
  </div>
</template>

<script>

export default {
  name: 'App',
}
</script>
