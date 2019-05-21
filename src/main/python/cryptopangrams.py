def gcd(numbera , numberb ):
    if(numbera  < numberb):
        temp = numbera
        numbera = numberb
        numberb = temp
    while(numberb > 0):
        temp = numberb
        numberb = numbera % numberb
        numbera = temp
    return numbera

def decrypt_pangram(cryptogram ):
    decoded_message = ""
    alphabet_set = set()
    encoded_cryptogram = ""
    characters = cryptogram.strip().split()
    cryptogram = ""
    i = 0
    while(int(characters[i])==int(characters[i+1])):
        i=i+1
    alpha2=gcd(int(characters[i]),int(characters[i+1]))
    first_char = int(characters[i])//alpha2
    j=i
    while(j>0):
        alpha3=int(characters[j-1])//first_char
        alphabet_set.add(first_char)
        encoded_cryptogram = ','+str(first_char) +','+encoded_cryptogram
        first_char=alpha3
        j=j-1
    encoded_cryptogram = ','+str(first_char) +','+ encoded_cryptogram
    alphabet_set.add(first_char)
    while ((i < len(characters)-1)):
        alpha3=int(characters[i+1])//alpha2
        alphabet_set.add(alpha2)
        encoded_cryptogram = encoded_cryptogram +','+ str(alpha2)+','
        alpha2=alpha3
        i=i+1
    encoded_cryptogram = encoded_cryptogram +','+ str(alpha2)+','
    alphabet_set.add(alpha2)
    characters=[]
    i = 0
    for alphabet in sorted(alphabet_set):
        encoded_cryptogram = encoded_cryptogram.replace(','+str(alphabet)+',',','+chr(65+i)+',')
        i = i+1
    decoded_message=encoded_cryptogram.replace(',','')
    return decoded_message

def solve_cryptopangrams():
    tests = input()
    for case in range(1,int(tests)+1):
        ignore=input()
        encrypted_pangram=input()
        print("Case #{}: {}".format(case,decrypt_pangram(encrypted_pangram)))

solve_cryptopangrams()
# encrypted_pangram="217 217 1891 4819 2291 2987 3811 1739 2491 4717 445 65 1079 8383 5353 901 187 649 1003 697 3239 7663 291 123 779 1007 3551 1943 2117 1679 989 3053"
# print(decrypt_pangram(encrypted_pangram))