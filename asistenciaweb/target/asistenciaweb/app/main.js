Vue.component('todo-alumno', {
    props: ['alumno'],
    template: '<tr><th>{{alumno.identificador}}</th><td>{{alumno.nombre}}</td><td><a class="button">Registrar</a></td></tr>'
});

var app = new Vue({
    el: '#main',
    data: {
        nombre : null,
        dni : null,
        telefono: null,
        correo: null,
        pagina : 1,
        alumnos : null
    },
    methods: {
        /*
        autenticar: function () {
            var vm = this;
            axios.post('servicios/agregarPaciente',
                {
                    identificador: null,
                    nombre:"Angel",
                    dni:"7275398",
                    telefono:"9999999",
                    correo:"jfranpineda@gmail.com"
                })
                .then(function (response) {
                    vm.nombre = response.data.nombre;
                    vm.pagina = 2;
                })

            console.log(this.usuario);
            console.log(this.credencial);
        },
        */
        obtenerAlumnos: function () {
            var vm = this;
            axios.post('servicios/obtenerAlumnos',null)
                .then(function (response) {
                   vm.alumnos = response.data;
                });
        },
        agregarPaciente: function () {
            var vm = this;
            axios.post('servicios/agregarPaciente',
                {
                    identificador: null,
                    nombre:vm.nombre,
                    dni:vm.dni,
                    telefono:vm.telefono,
                    correo:vm.correo
                })
                .then(function (response) {
                    vm.nombre = response.data.nombre;
                    vm.pagina = 2;
                })
        }

    }
});
app.obtenerAlumnos();