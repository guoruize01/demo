
#include <string.h>
// #include <cassert>
#include <sstream>
#include <vector>

int main(){
    char input[2000];
    scanf("%s",input);
    uint32_t num = std::stoi(input,0,16);
    uint32_t out = 0;
    out = add(num);
    printf("0x%08x",out);
    return 0;
}