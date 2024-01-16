import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {RecipeService} from "../recipes/recipe.service";
import {Recipe} from "../recipes/recipe.model";
import {Observable} from "rxjs";

@Injectable({providedIn:'root'})
export class DataStorageService{
  private apiUrl = 'http://localhost:8080/soap-api';

  constructor(private http:HttpClient,private recipeService:RecipeService) {
}

storeRecipes(){
  const recipes=this.recipeService.getRecipes();
  console.log(recipes);
  this.http.put('http://localhost:8081/api/recipes',recipes).
  subscribe(
    reponse=>{
      console.log(reponse);
    }
  );
}
  fetchRecipes() {
    this.http.get<Recipe[]>('http://localhost:8081/api/recipes')
      .subscribe(recipes=>{
        console.log(recipes);
        this.recipeService.setRecipes(recipes);
      });
  }
  deleteRecipe( id:number) {
    console.log("delet"+id);
    this.http.delete(`http://localhost:8081/api/recipes/${id}`).subscribe(
      (response) => {
        console.log('Recipe deleted successfully:', response);
      },
      (error) => {
        console.error('Error deleting recipe:', error);
      }
    );
  }

  editRecipe(updatedRecipe: Recipe) {
    this.http.put<Recipe>(`http://localhost:8081/api/recipes/`, updatedRecipe).
    subscribe(
      reponse=>{
        console.log(reponse);
      }
    );
  }
  getShoppingList(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${id}`);
  }
  getAllShoppingLists(): Observable<any> {
    return this.http.get(this.apiUrl);
  }
  saveShoppingList(shoppingList: any): Observable<any> {
    return this.http.post(this.apiUrl, shoppingList);
  }
}
