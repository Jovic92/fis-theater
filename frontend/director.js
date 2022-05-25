Vue.createApp({
    data() {
        return {
            directors: [],
            shows: []
        }
    },
    methods: {
        getShows(directorId) {
            console.log(directorId)
            axios
                .get("http://localhost:8080/show/director/" + directorId)
                .then(resp => {
                    this.shows = resp.data
                    console.log(this.shows)
                    this.shows.forEach(element => {
                        element.tempGeneres = element.genres.join()
                    });
                    // this.shows.tempGeneres = this.shows.genres.join()
                })
        }
    },
    mounted: function () {
        axios
            .get("http://localhost:8080/directors/all")
            .then(resp => {
                this.directors = resp.data
            })
    }
}).mount("#director")
