import React from 'react';
import { render } from '@testing-library/react';
import { Metric } from "./Metric";
import { MockedProvider, wait } from '@apollo/react-testing';
import { QUERY } from "../queries/FindAllMetricsQuery";
import { act } from "react-dom/test-utils";

const mocks = [
    {
        request: {
            query: QUERY,
            variables: {},
        },
        result: {
            data: {
                findAllMetrics: [{ id: '1', name: 'Buck', description: 'bulldog', lifeCycleStatus: 'COMPLETE' }],
            },
        },
    },
];

const wrappedRender = () => render(
    <MockedProvider mocks={mocks} addTypename={false}>
        <Metric />
    </MockedProvider>
);

test('renders table with a row', async () => {
    await act(async () => { // This ensures that you're testing the behavior the user would see in the browser. Learn more at https://fb.me/react-wrap-tests-with-act
        const { getByText } = wrappedRender();

        await wait(0); // wait for response, else you get a Loading... message.

        expect(getByText(/Name/i)).toBeInTheDocument();
        expect(getByText(/Description/i)).toBeInTheDocument();
        expect(getByText(/Life Cycle Status/i)).toBeInTheDocument();
        expect(getByText(/Buck/i)).toBeInTheDocument();
        expect(getByText(/bulldog/i)).toBeInTheDocument();
        expect(getByText(/COMPLETE/i)).toBeInTheDocument();
    });
});

test('renders Loading...', async () => {
    await act(async () => {
        const {getByText} = render(
            <MockedProvider mocks={[]} addTypename={false}>
                <Metric/>
            </MockedProvider>
        );
        expect(getByText(/Loading.../i)).toBeInTheDocument();
    });
});
