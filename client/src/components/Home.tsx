import React, {FunctionComponent, useState} from "react";
import { AppBar, Box, Tab, Tabs, Typography } from "@material-ui/core";
import { Metric } from "./Metric";

interface TabPanelProps {
    children?: React.ReactNode;
    index: any;
    value: any;
}

function TabPanel(props: TabPanelProps) {
    const { children, value, index, ...other } = props;

    return (
        <Typography
            component="div"
            role="tabpanel"
            hidden={value !== index}
            id={`simple-tabpanel-${index}`}
            aria-labelledby={`simple-tab-${index}`}
            {...other}
        >
            {value === index && <Box p={3}>{children}</Box>}
        </Typography>
    );
}

export const Home: FunctionComponent = () => {
    const [value, setValue] = useState(0);

    return (
        <div className="App">
            <AppBar position="static">
                <Tabs value={value} onChange={(event, newValue) => setValue(newValue)} aria-label="simple tabs example">
                    <Tab label="Metric" />
                    <Tab label="Objective" />
                    <Tab label="Project" />
                </Tabs>
            </AppBar>
            <TabPanel value={value} index={0}>
                <Metric/>
            </TabPanel>
            <TabPanel value={value} index={1}>
                Item Two
            </TabPanel>
            <TabPanel value={value} index={2}>
                Item Three
            </TabPanel>
        </div>
    );
};
