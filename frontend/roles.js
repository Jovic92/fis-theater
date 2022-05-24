Vue.createApp({
    data() {
        return {
            showName: '',
            roles: []
        }
    },
    methods: {
        find() {
            axios
                .get("http://localhost:8080/role/" + this.showName)
                .then(resp => {
                    this.roles = resp.data
                })
                .catch(function (error) {
                    alert("Error has happened")
                })
        }
    },
    mounted: function () {

    }
}).mount("#role")
