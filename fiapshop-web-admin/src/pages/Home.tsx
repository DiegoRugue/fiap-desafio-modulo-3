import { Alert, AlertDescription, AlertIcon, AlertTitle, Box, Button, Container, Flex, IconButton, Spinner, Table, TableContainer, Tbody, Td, Text, Th, Thead, Tr } from "@chakra-ui/react"
import { MdModeEdit, MdDelete } from "react-icons/md";
import Header from "../components/Header"
import { getProducts } from "../services/getProducts";

export function Home() {
  const { products, error, loading } = getProducts()
  return <>
    <Header />

    <Flex justify="space-around">
      <Box marginBottom={8}>
        <Text fontSize={"xl"} fontWeight={"semibold"}>Produtos</Text>
      </Box>
      <Box>
        <Button colorScheme='blue'>Novo Produto</Button>
      </Box>
    </Flex>

    <Container maxW={"max-content"}>
      <Flex justify={"center"} minW={"max-content"}>
        {loading ? <Spinner size='xl' /> : <></>}
        {error !== null ? <Alert status='error'>
          <AlertIcon />
          <AlertTitle>Falha ao se comunicar com servidor</AlertTitle>
          <AlertDescription>Serviço temporariamente indisponível</AlertDescription>
        </Alert> : <></>}
      </Flex>

      {!loading && error === null && products.length > 0 ?
        <TableContainer>
          <Table variant={"simple"} maxW={"max-content"}>
            <Thead>
              <Tr>
                <Th w={"md"}>Nome</Th>
                <Th w={"md"}>Preço</Th>
                <Th w={16}>Editar</Th>
                <Th w={16} >Excluir</Th>
              </Tr>
            </Thead>
            <Tbody>
              { products.map(product => {
                return (
                  <Tr>
                    <Td w={"md"}>{product.name}</Td>
                    <Td w={"md"}>{product.price}</Td>
                    <Td w={16}><IconButton aria-label='Editar produto' icon={<MdModeEdit />} /></Td>
                    <Td w={16}><IconButton colorScheme={"red"} aria-label='Excluir produto' icon={<MdDelete />} /></Td>
                  </Tr>
                )
              }) }

            </Tbody>
          </Table>
        </TableContainer>
        : <Alert status='info'>
            <AlertIcon />
            Ainda não há produtos cadastrados, experimente cadastrar algum.
          </Alert>
      }
    </Container>
  </>
}
