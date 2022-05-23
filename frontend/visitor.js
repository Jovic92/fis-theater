Vue.createApp({
    data() {
        return {
            visitor: {
                firstname: '',
                lastname: '',
                visitorId: 0
            },
            visitors: []
        }
    },
    methods: {
        addVisitor() {
            // alert("ABOUT TO ADD VISITOR " + this.visitor.firstname + " " + this.visitor.lastname)
            axios
                .post("http://localhost:8080/visitor/save", this.visitor)
                .then(response => {
                    console.log(response)
                    this.getAllVisitors()
                })
                .catch(function (error) {
                    console.log(error)
                    alert("AN ERROR HAS OCCURED")
                })

        },
        findVisitor() {


            axios
                .get("http://localhost:8080/visitors/get/" + this.visitor.firstname + "/" + this.visitor.lastname)
                .then(response => this.visitors = response.data)
                .catch(function (error) {
                    console.log(error)
                    alert("AN ERROR HAS OCCURED")
                })
        },
        findVisitorById() {
            axios
                .get("http://localhost:8080/visitors/get/" + this.visitor.visitorId)
                .then(response => this.visitors = response.data)
                .catch(function (error) {
                    console.log(error)
                    alert("AN ERROR HAS OCCURED")
                })
        },
        updateVisitor() {
            axios
                .put("http://localhost:8080/visitor/save", this.visitor)
                .then(response => {
                    console.log(response)
                    this.getAllVisitors()
                })
                .catch(function (error) {
                    console.log(error)
                    alert("AN ERROR HAS OCCURED")
                })
        },
        deleteVisitor(vid) {
            axios
                .delete("http://localhost:8080/visitor/delete/" + vid)
                .then(response => {
                    console.log(response)
                    this.getAllVisitors()
                })
                .catch(function (error) {
                    console.log(error)
                    alert("AN ERROR HAS OCCURED")
                })
        },
        getAllVisitors() {
            axios
                .get("http://localhost:8080/visitors/getAll")
                .then(response => this.visitors = response.data)
                .catch(function (error) {
                    console.log(error)
                    alert("AN ERROR HAS OCCURED")
                })

        }
    },
    mounted: function () {
        axios
            .get("http://localhost:8080/visitors/getAll")
            .then(response => this.visitors = response.data)
            .catch(function (error) {
                console.log(error)
                alert("AN ERROR HAS OCCURED")
            })
    }
}).mount("#visitor")
