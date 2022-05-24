Vue.createApp({
    data() {
        return {
            showName: '',
            roles: [],
            message: ''
        }
    },
    methods: {
        find() {
            axios
                .get("http://localhost:8080/role/" + this.showName)
                .then(resp => {
                    this.roles = resp.data
                    if (this.roles.length != 0) {
                        this.message = ''
                    } else {
                        this.message = "No results found"
                    }
                })
                .catch(function (error) {
                    this.message = "Error has happened"
                    alert("Error has happened")
                })
        }
    },
    mounted: function () {

    }
}).mount("#role")
