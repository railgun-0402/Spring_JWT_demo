<template>
    <div>
        <h1>キャラクター一覧</h1>
        <ul>
            <li v-for="character in characters" :key="character.id">
                {{character.name}}
            </li>
        </ul>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'Character',
    data() {
        return {
            characters: []
        }
    },
    mounted() {
        axios.get('http://localhost:8080/api/stock',{
            headers: {
                "X-AUTH-TOKEN" : "Bearer " + this.$store.getters.getToken
            }
        })
        .then( res => {
            this.characters = res.data
        })
        .catch( e => {
            alert("エラーが発生しました")
            console.log(e)
        })
    },   
    
}
</script>