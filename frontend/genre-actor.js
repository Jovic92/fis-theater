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
        axios.defaults.headers.common['Authorization'] = `Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJiYWNrZW5kIiwic3ViIjoibSIsImF1ZCI6IndlYiIsImlhdCI6MTY1MzUwMDQwMCwiZXhwIjoxNjUzNTAyMjAwfQ.LWwwO2-iyb5I5lkUkakF4wZZLcENL9acKAyPVUTHLEQN9UDYZ34EvEel0Y9vDi5X4fI0ZSpISuW0MdrMt15CFQ` 
        axios
            .get("http://localhost:8080/genre/all", {
                // headers: {
                //     'Authorization': 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJiYWNrZW5kIiwic3ViIjoibSIsImF1ZCI6IndlYiIsImlhdCI6MTY1MzUwMDQwMCwiZXhwIjoxNjUzNTAyMjAwfQ.LWwwO2-iyb5I5lkUkakF4wZZLcENL9acKAyPVUTHLEQN9UDYZ34EvEel0Y9vDi5X4fI0ZSpISuW0MdrMt15CFQ'
                // }
            })
            .then(response => {
                this.genres = response.data
            })
            .catch(function (error) {
                alert("ERROR")
            })
    }
}).mount("#genre-act")


// login page
//token set in localstorage
// localStorage.set["k", token]
// axios.defaults.headers.common['Authorization'] = 'Bearer ' + localStorage.get["k"]