'use strict'
const express= require('express')
const bodyParser = require('body-parser')
var mysql = require('mysql');
const app = express()
const port = process.env.PORT || 3000

//Importar Rutas

const customerRouter = require('./src/router/customer')
//middlewares
var con = mysql.createConnection({
  host: "127.0.0.1",
  user: "root",
  password: "Miguel1998xd"
});
con.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
});


//parsear
app.use(bodyParser.urlencoded({ extended:false }))
app.use(bodyParser.json())
app.use('/',customerRouter);
// static files
//app.use(express.static(path.join(_dirname,'public')));


//Peticiones
app.get('/api/product',(req,res)=>{
  res.send(200,{products:[]})
})
app.get('/api/product/:productID',(req,res)=>{

})
app.post('/api/product', (req,res)=>{
  console.log(req.body)
  res.send(200,{message:'El Producto se ha recibido'})
})
app.put('/api/product/:productID',(req,res)=>{

})
app.delete('/api/product/:productID',(req,res)=>{

})
app.listen(port,()=>{
  console.log(`apiiii ${port}`)
})
