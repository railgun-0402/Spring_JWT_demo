<template>
  <div>
    <h1>ログイン</h1>
    <form>
      <div>
        <label>ユーザ名</label>
        <input v-model="username" type="text" id="username" />
      </div>
      <div>
        <label>パスワード</label>
        <input v-model="password" type="password" id="password" />
      </div>
      <div>
        <button type="button" @click="login">ログイン</button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'Login',
    data() {
        return {
            username: "",
            password: ""
        }
    },
    methods: {
        login() {
            axios.post('http://localhost:8080/api/login', {
                username: this.username,
                password: this.password
            })
                .then(res => {
                    console.log(res)
                    this.$store.dispatch('saveToken', res.headers['x-auth-token'])
                    // Homeへ
                    this.$router.push('/')
                })
                .catch(e => {
                    alert("ログインに失敗しました")
                    console.log(e)
            })
        }
    }
}
</script>