Vue.createApp({
    data() {
        return {
            directors: []
        }
    },
    methods: {

    },
    mounted: function () {
        axios
            .get("http://localhost:8080/directors/all")
            .then(resp => {
                this.directors = resp.data
            })
    }
}).mount("#director")
