Vue.createApp({
    data() {
        return {
            actor: {
                firstName: '',
                lastName: ''
            },
            actorRole: {
                actorId: 0,
                roleId: 0,
                showId: 0,
                performanceId: 4
            },
            shows: [],
            showName: '',
            roles: [],
            show:{}
        }
    },
    methods: {
        addActor() {
            axios
                .post("http://localhost:8080/actor", this.actor)
                .then(resp => {
                    console.log(resp)
                    this.actorRole.actorId = resp.data.idActor
                    // alert("An actor has been added")
                    this.getAllShows()
                })
                .catch(function (erroreewafshrjd) {
                    console.log(erroreewafshrjd)
                    alert("ERROR OCCURED")
                })
        },
        saveRole(roleId) {
            this.actorRole.roleId=roleId
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
        },
        getAllShows() {
            axios
                .get("http://localhost:8080/show/getAll/")
                .then(response => {
                    console.log(response)
                    this.shows = response.data
                })
                .catch(function (error) {
                    console.log(error)
                    alert("AN ERROR HAS OCCURED")
                })
        },
        findAllRolesForAShow() {
            axios
                .get("http://localhost:8080/role/" + this.showName)
                .then(resp => {
                    this.roles = resp.data
                    if (this.roles.length != 0) {
                        console.log("aaaaaa")
                        console.log(this.roles)
                        this.message = ''
                    } else {
                        this.message = "No results found"
                    }
                })
                .catch(function (error) {
                    this.message = "Error has happened"
                    alert("Error has happened")
                })
        },
        setSelectedShow() {
            this.shows.forEach(elem => {
                if (elem.name === this.showNameForSearch) {
                    this.actorRole.showId = elem.id
                    alert(this.actorRole.showId)
                    this.show = elem
                    console.log(this.show)
                    this.showName = this.showNameForSearch
                    this.findAllRolesForAShow()
                }
            })
        }
    },
    mounted: function () {

    }
}).mount("#act")
