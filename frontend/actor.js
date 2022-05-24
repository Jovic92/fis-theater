Vue.createApp({
    data() {
        return {
            actor: {
                firstName: '',
                lastName: ''
            },
            actorRole: {
                actorId: 1,
                roleId: 15,
                showId: 3,
                performanceId: 3
            }
        }
    },
    methods: {
        addActor() {
            axios
                .post("http://localhost:8080/actor", this.actor)
                .then(resp => {
                    console.log(resp)
                    alert("An actor has been added")
                })
                .catch(function (erroreewafshrjd) {
                    console.log(erroreewafshrjd)
                    alert("ERROR OCCURED")
                })
        },
        saveRole() {
            axios
                .put("http://localhost:8080/actor/saveRole", this.actorRole)
                .then(resp => {
                    console.log(resp)
                    alert("An actor has been given a role")
                })
                .catch(function (erroreewafshrjd) {
                    console.log(erroreewafshrjd)
                    alert("ERROR OCCURED")
                })
        }
    },
    mounted: function () {

    }
}).mount("#act")
