import { Component, OnInit,ViewEncapsulation} from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs';
import { HttpClient} from '@angular/common/http';
import { HttpHeaders} from '@angular/common/http';
import {catchError} from 'rxjs/operators'

@Component({
  selector: 'app-evaluacionprospecto',
  templateUrl: './evaluacionprospecto.component.html',
  encapsulation:ViewEncapsulation.None,
  styleUrls: ['./evaluacionprospecto.component.css']
})
export class EvaluacionprospectoComponent implements OnInit {


  clientes:any={};
  clientes2:any={};
  loading:boolean=false;
  usuario:any;
  objUsuario:any={};




  constructor(private modal:NgbModal,private http:HttpClient) { }


  ngOnInit(): void {

    this.usuario=localStorage.getItem('usuario');
    this.objUsuario = JSON.parse(this.usuario);
if(!this.objUsuario){
  location.href="/"
}
    if(this.objUsuario.rol_idrol==1){


    }
    else{
      alert("ERROR: SOLO LOS ADMINISTRADORES PUEDEN ACCEDER A ESTE APARTADO")
      location.href="/prospecto"
    }

 this.buscarClientes();
  }

  openScroll(contenido:any){

    this.modal.open(contenido,{scrollable:true});
  }

buscarClientes(){
  this.loading=true;
  this.buscarCientesServicio().subscribe(
    (response:any)=>this.llenarClientes(response));
}

  llenarClientes(clientes:any){
    this.clientes=clientes;
    this.loading=false;

  }

  buscarCientesServicio():Observable<any>{
    return this.http.get<any>("http://localhost:3030/cliente/buscar/").pipe(
      catchError(e=>"error")
      )

  }


  getIdcliente(idCliente:any,nombreProspecto:any,primerApellido:any,segundoApellido:any,calle:any,
    numero:any,colonia:any,codigoPostal:any,telefono:any,rfc:any,documentos:any,statusProspecto:any,observacion:any,opcion:any){

    this.clientes2.idcliente=idCliente;
    this.clientes2.nombreProspecto=nombreProspecto;
    this.clientes2.primerApellido=primerApellido;
    this.clientes2.segundoApellido=segundoApellido;
    this.clientes2.calle=calle;
    this.clientes2.numero=numero;
    this.clientes2.colonia=colonia;
    this.clientes2.codigoPostal=codigoPostal;
    this.clientes2.telefono=telefono;
    this.clientes2.rfc=rfc;
    this.clientes2.documentos=documentos;

    this.clientes2.observacion=observacion;
    if(opcion==1){
      this.clientes2.statusProspecto="AUTORIZADO";
    }else{
      this.clientes2.statusProspecto="RECHAZADO";
    }

    this.ActualizarProspecto(this.clientes2);

  }


  ActualizarProspecto(prospectoActualizado:any){
    this.clientes2=prospectoActualizado;
      this.loading=true;
      this.actualizarService(this.clientes2).subscribe(
        data => this.confirmar(data)
        )
        location.reload();
      }


      actualizarService(prospectoActualizado:any){
        this.clientes2=prospectoActualizado;
        var httpOptions ={
          headers:new HttpHeaders({
            'Content-Type':'application/json'
          })
        }
        return this.http.post<any>("http://localhost:3030/cliente/guardar",this.clientes2,httpOptions);
      }

      confirmar(resultado:any){
        this.loading=false;

      if(resultado){
   alert("AUTORIZACION CON OBSERVACIONES ENVIADA CON EXITO!!")


      }else{
        //si es nulo
        alert("ERROR: FAVOR DE VERIFICAR BIEN LA INFORMACION ")
      }
      }




}
