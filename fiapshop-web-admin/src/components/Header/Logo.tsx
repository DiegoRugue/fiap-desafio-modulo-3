import { Box, Text } from "@chakra-ui/react"

type LogoProps = {
  name: string
}

export default function Logo(props: LogoProps) {
  return (
    <Box>
      <Text fontSize="2xl" fontWeight="bold">
        {props.name}
      </Text>
    </Box>
  )
}
