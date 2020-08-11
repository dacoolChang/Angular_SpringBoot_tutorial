import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HelloComponent } from './hello/hello.component'
import { AppComponent } from './app.component';
import { WorldComponent } from './world/world.component';

const routes: Routes = [
    { path: 'hello', component: HelloComponent },
    { path: 'world', component: WorldComponent },
    { path: 'app', component: AppComponent },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
