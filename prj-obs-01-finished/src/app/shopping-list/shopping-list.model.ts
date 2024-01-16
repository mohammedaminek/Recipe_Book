import { Ingredient } from '../shared/ingredient.model';

export class ShoppingList {
  constructor(public ingredients: Ingredient[],public   id?: number) {
  }
}
