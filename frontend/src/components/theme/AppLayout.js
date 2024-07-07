const AppLayout = ({ children }) => {
    const [ThemeMode, toggleTheme] = useTheme();
    return (
        <WrapContainer>
            <Header />
            <ThemeToggle toggle={toggleTheme} mode={ThemeMode}>
                DarkMode
            </ThemeToggle>
            <FlexContainer>{children}</FlexContainer>
        </WrapContainer>
    )
}
export default AppLayout;