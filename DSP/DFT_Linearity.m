
N=24;
fs=24000;
f1=3000;
f2=11000;
ts=1/fs;
ind=1;
x1=zeros(1,N);
x2=zeros(1,N);
a=4;
b=7;
for n=0:N-1
    m=n-1;
    x1(ind)=a*sin(2*pi*f1*m*ts);
    x2(ind)=b*sin(2*pi*f2*m*ts);
    ind=ind+1;
end
x_comb=x1+x2;
 
X1=dft(x1,N);
X2=dft(x2,N);
X_comb_direct=dft(x_comb,N);
X_sum=X1+X2;
X_sum_Mag=abs(X_sum);
X_comb_direct_Mag=abs(X_comb_direct);
 
 
DFT_Linearity_Error=max(abs(X_comb_direct-X_sum));
if DFT_Linearity_Error<10e-6
    disp('DFT linearity is proved');
else
   disp('DFT linearity is not proved');
end
 
figure(1)
plot(1:N,x1,'r--o');
grid on;
xlabel('Time (milisecond)');
ylabel('Signal Amplitude');
title('x-seq1 signal versus time');
 
figure(2)
plot(1:N,x2,'b--o');
grid on;
xlabel('Time (milisecond)');
ylabel('Signal Amplitude');
title('x-seq2 signal versus time');
 
figure(3)
plot(0:N-1,X_comb_direct_Mag);
grid on;
xlabel('Time (milisecond)');
ylabel('Signal Amplitude');
title('Combinational sum of signal versus time');
 
figure(4)
plot(0:N-1,X_sum_Mag,'r');
grid on;
xlabel('Time (milisecond)');
ylabel('Signal Amplitude');
title('Combinational sum of signal versus time');
 
function X=dft(x,N)
    X=zeros(1,N);
    for k=0:N-1
        X(k+1)=0;
        for n=0:N-1
            X(k+1)=X(k+1)+x(n+1)*exp(-1j*2*pi*k*n/N);
        end
    end
end
 

