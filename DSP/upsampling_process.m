L=input('enter the upsampling factor : ');
N=input('enter the length of the input signal : '); % Length should be greater than 8
f1=input('enter the frequency of first sinusodal : ');
f2=input('enter the frequency of second sinusodal : ');
n=0:N-1;
x=sin(2*pi*f1*n)+sin(2*pi*f2*n);
y=interp(x,L);
subplot(2,1,1)
stem(n,x(1:N))
title('input sequence');
xlabel('time(n)');
ylabel('amplitude');
subplot(2,1,2)
m=0:N*L-1;
stem(m,y(1:N*L));
