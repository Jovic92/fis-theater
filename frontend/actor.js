Vue.createApp({
    data() {
        return {
            actor: {
                firstName: '',
                lastName: ''
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
        }
    },
    mounted: function () {

    }
}).mount("#act")
