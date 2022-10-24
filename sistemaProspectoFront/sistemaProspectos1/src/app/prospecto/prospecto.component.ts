import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { HttpHeaders} from '@angular/common/http';
import {Storage,ref,uploadBytes } from '@angular/fire/storage';


@Component({
  selector: 'app-prospecto',
  templateUrl: './prospecto.component.html',
  styleUrls: ['./prospecto.component.css']
})
export class ProspectoComponent implements OnInit {
  loading:any;
  prospecto:any={};


  constructor(private http: HttpClient, private storage:Storage){}

  ngOnInit(): void {

  }


  crear(){
    let formulario:any=document.getElementById("crear");
    let formularioValido:boolean= formulario.reportValidity();
    if(formularioValido){
      this.loading=true;
      this.crearService().subscribe(
        data => this.confirmar(data)
        )
    }
      }

      crearService(){
        var httpOptions ={
          headers:new HttpHeaders({
            'Content-Type':'application/json'
          })
        }
        this.prospecto.statusProspecto="ENVIADO";
        return this.http.post<any>("http://localhost:3030/cliente/guardar",this.prospecto,httpOptions);
      }

      confirmar(resultado:any){
        this.loading=false;

      if(resultado){
   alert("usuario creado con exito!")
   this.prospecto={};

      }else{
        //si es nulo
        alert("error al crear al usuario!")
      }
      }


      uploadImage($event: any) {
        const file = $event.target.files;
        console.log(file);
        for (let i = 0 ; i <=file.length ; i++) {

          const imgRef = ref(this.storage, `archivos/${file[i].name}`);

          uploadBytes(imgRef, file[i])
            .then(response => {
              console.log(response)
              this.prospecto.documentos=this.prospecto.documentos+"-"+response.metadata.fullPath;
            })
            .catch(error => console.log(error));

          }



      }


}