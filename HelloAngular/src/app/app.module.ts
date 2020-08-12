import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule} from './app.routing.module'

import { AppComponent } from './app.component';
import { HelloComponent } from './hello/hello.component';
import { WorldComponent } from './world/world.component';

import { HelloService } from './hello.service';

@NgModule({
  declarations: [
    AppComponent,
    HelloComponent,
    WorldComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [HelloService],
  bootstrap: [AppComponent]
})
export class AppModule { }
