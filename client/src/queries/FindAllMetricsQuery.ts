import gql from 'graphql-tag';
import { useQuery } from "@apollo/react-hooks";
import { FindAllMetrics } from "../types/FindAllMetrics";

export const QUERY = gql`
    query FindAllMetrics {
        findAllMetrics {
            id
            name
            description
            lifeCycleStatus
        }
    }
`;

export const useFindAllMetricsQuery = () => useQuery<FindAllMetrics>(QUERY);
