import axios from 'axios';
<template>
    <div>
        <h1>ガチャ</h1>
        <button type="button" @click="play">ガチャを引く</button>
        <div><strong>{{error}}</strong></div>
        <ul>
            <li v-for="record in records" :key="record.id">
                {{ record.name }}
            </li>
        </ul>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'Gacha',
    data() {
        return {
            records: [],
            error: ""
        }
    },
    methods: {
        play() {
            axios.post('http://localhost:8080/api/playgacha', {}, {
                headers: {
                    "X-AUTH-TOKEN" : "Bearer " + this.$store.getters.getToken
                }
            })
                .then(res => {
                    console.log(res)
                    if ("message" in res.data) {
                        this.error = res.data.message
                    } else {
                        this.error = ""
                        this.records = res.data
                    }
                })
                .catch(err => {
                    alert("エラーが発生しました")
                    console.log(err)
            })
        },
        mounted() {
            axios.get('http://localhost:8080/api/islogin', {
                headers: {
                "X-AUTH-TOKEN" : "Bearer " + this.$store.getters.getToken
            }
            })
                .then(res => {
            console.log(res)
                })
                .catch(() => {
                    alert("ログインしてください")
                    this.$router.push('/login')
        })
    }
    }
}
</script>
