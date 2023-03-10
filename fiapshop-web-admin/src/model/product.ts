export type Product = {
  id: number,
  name: string,
  description: string,
  price: number,
  imageUri: string,
}

export type CreateProduct = Omit<Product, "id">
