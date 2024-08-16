import {createRouter, createWebHistory} from 'vue-router'

import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Gacha from '../views/Gacha.vue'
import Character from '../views/Character.vue'

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/login',
        name: 'Login',
        component: Login
    },
    {
        path: '/gacha',
        name: 'Gacha',
        component: Gacha
    },
    {
        path: '/character',
        name: 'Character',
        component: Character
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router