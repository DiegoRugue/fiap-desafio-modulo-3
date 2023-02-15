import { useEffect, useState } from "react";
import { Product } from "../model/product";
import { api } from './api';

export function getProducts() {
  const [ products, setProducts ] = useState<Product[]>([])
  const [ loading, setLoading ] = useState(true)
  const [ error, setError ] = useState<Error | null>(null)

  useEffect(() => {
    api.get<Product[]>("/products")
      .then(response => setProducts(response.data))
      .catch(err => setError(err))
      .finally(() => setLoading(false))
  }, [])

  return { products, loading, error }
}
