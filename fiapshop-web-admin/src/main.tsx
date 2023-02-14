import React from 'react'
import ReactDOM from 'react-dom/client'

import { ChakraProvider } from '@chakra-ui/react'

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
    <ChakraProvider>
      <h1>Fiap Shop</h1>
    </ChakraProvider>
  </React.StrictMode>,
)
