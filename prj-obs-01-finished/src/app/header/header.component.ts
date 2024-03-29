import { Component } from '@angular/core';
import {DataStorageService} from "../shared/data-storage.service";
import {AuthService} from "../shared/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
})
export class HeaderComponent {
  constructor(private dataStorageService:DataStorageService,
              public authService:AuthService,
              private router:Router
              ) {
  }
  onSaveData() {
    this.dataStorageService.storeRecipes();
  }

  onFetchData() {
    this.dataStorageService.fetchRecipes();
  }

  handelLogout() {
    this.authService.logout();
    this.router.navigateByUrl("/login");
  }
}
