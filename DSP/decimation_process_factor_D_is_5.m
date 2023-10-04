D=input('enter the downsampling factor : ');
L=input('enter the length of the input signal : ');
f1=input('enter the frequency of first sinusodal : ');
f2=input('enter the frequency of second sinusodal : ');
n=0:L-1;
x=sin(2*pi*f1*n)+sin(2*pi*f2*n);
y=decimate(x,D);
subplot(2,1,1);
stem(x);
subplot(2,1,2);
stem(y);


