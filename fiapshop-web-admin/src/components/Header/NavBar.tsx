import { Flex } from "@chakra-ui/react"

type NavBarProps = {
  children: JSX.Element
}

export default function NavBar (props: NavBarProps) {
  return (
    <Flex
      as="nav"
      align="center"
      justify="space-between"
      wrap="wrap"
      w="100%"
      mb={8}
      p={8}
      bg={["blue.900"]}
      color={["whiteAlpha.900"]}
    >
      {props.children}
    </Flex>
  )
}
