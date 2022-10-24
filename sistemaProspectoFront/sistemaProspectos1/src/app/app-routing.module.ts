import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ProspectoComponent } from './prospecto/prospecto.component';
import { ModalComponent } from './modal/modal.component';
import { EvaluacionprospectoComponent } from './evaluacionprospecto/evaluacionprospecto.component';


const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'prospecto',component:ProspectoComponent},
  {path:'modal',component:ModalComponent},
  {path:'evaluacionprospecto',component:EvaluacionprospectoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
