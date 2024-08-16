import { createStore } from "vuex";

const store = createStore({
    state() {
        return {
            token: ""
        }
    },
    mutations: {
        saveToken(state, token) {
            state.token = token
        },
        removeToken(state) {
            state.token = ""
        }
    },
    actions: {
        saveToken({ commit }, token) {
            commit("saveToken", token)
        },
        removeToken({ commit }) {
            commit("removeToken")
        }
    },
    getters: {
        getToken(state) {
            return state.token
        }
    }
});

export default store