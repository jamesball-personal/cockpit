import React from 'react';
import { Home } from "./components/Home";
import ApolloProvider from 'react-apollo/ApolloProvider';
import { ApolloProvider as ApolloHooksProvider } from '@apollo/react-hooks';
import { client } from "./graphQL";

function App() {
    return (
        <ApolloProvider client={client}>
            <ApolloHooksProvider client={client}>
                <Home />
            </ApolloHooksProvider>
        </ApolloProvider>
    );
}

export default App;
