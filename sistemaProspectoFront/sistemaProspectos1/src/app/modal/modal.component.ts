import { Component, OnInit,ViewEncapsulation} from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs';
import { HttpClient} from '@angular/common/http';
import { HttpHeaders} from '@angular/common/http';
import {catchError} from 'rxjs/operators'

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  encapsulation:ViewEncapsulation.None,
  styleUrls: ['./modal.component.css']
})

export class ModalComponent implements OnInit {
  clientes:any={};
  loading:boolean=false;
  valor:any;
  activo:any;


  constructor(private modal:NgbModal,private http:HttpClient) { }


  ngOnInit(): void {
 this.buscarClientes();
  }

  openScroll(contenido:any){
    this.activo=true;
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
    console.log(this.clientes.nombreProspecto+" "+this.clientes.primerApellido+" "+this.clientes.calle)

  }

  buscarCientesServicio():Observable<any>{
    return this.http.get<any>("http://localhost:3030/cliente/buscar/").pipe(
      catchError(e=>"error")
      )

  }





    }









