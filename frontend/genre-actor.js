Vue.createApp({
    data() {
        return {
            genres: [],
            genreName: '',
            genereId: 0,
            genreDTO: {
                idGenre: 0,
                name: ''
            },
            shows: [],
            showDTO: {
                id: 0,
                name: ''
            },
            actors: []
        }
    },
    methods: {
        selectGenre() {
            console.log(this.genreDTO)
            axios
                .get("http://localhost:8080/show/genre/" + this.genreDTO.idGenre)
                .then(response => {
                    this.shows = response.data
                    console.log(this.shows)
                })
                .catch(function (error) {
                    alert("ERROR")
                })
        },
        selectShow() {
            console.log(this.showDTO)
        },
        getAllActors() {
            alert("A")
            axios
                .get("http://localhost:8080/actor/getAll")
                .then(response => {
                    this.actors = response.data
                    console.log(this.actors)
                })
                .catch(function (error) {
                    alert("ERROR")
                })
        }

    },
    mounted: function () {
        axios
            .get("http://localhost:8080/genre/all")
            .then(response => {
                this.genres = response.data
            })
            .catch(function (error) {
                alert("ERROR")
            })
    }
}).mount("#genre-act")
